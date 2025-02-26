import bodyParser from 'body-parser'
import express from "express";
import cors from 'cors'
import {RomanceService} from "../service/romance.service.js";
import {log} from "../log/log.app.js";

const router = express.Router()
const app = express()
const romanceServiceClass = new RomanceService()
/**
 *** a Port should follow angular port that you set it on docker (Port that you exposed)
 cors provides Express middleware to enable CORS with various options.
 CORS (Cross-Origin Resource Sharing) คือ กลไกที่ทำให้ server สามารถกำหนดสิทธิการเข้าถึงทรัพยากรได้ เมื่อมีเว็บไซต์ที่มี origin (domain) อื่น ใช้ HTTP request มายัง server
 ** in this case 3000 port I use it for back end
 ** corsOptions เพื่อบอกว่าจะอนุญาต domain ไหนสามารถ sent http method ได้
 ** angular default 4200 but my container I exposed 4000
 */
const corsOptions = {
  origin: 'http://localhost:4001'
}
// set router
router.use(bodyParser.json())
router.use(bodyParser.urlencoded({extended: true}))
router.use(cors(corsOptions));
router.get('/api/reads', async (req, res) => {
  return res
    .status(202)
    .json({
      status: "accepted",
      data: romanceServiceClass.retrieveAllRomances()
    })
})

// set app
app.use(router)
app.listen(3000, (error) => {
  if (!error) {
    log.info(`You're on port 3000`)
  } else {
    throw error
  }
})





