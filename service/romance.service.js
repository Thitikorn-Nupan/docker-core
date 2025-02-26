import {Romance} from "../entity/romance.js";

export class RomanceService {
  #romances
  constructor() {
    this.#romances = []
    this.#romances[0]= new Romance(1,"romance","romance",500);
    this.#romances[1]= new Romance(2,"romance","romance",500);
    this.#romances[2]= new Romance(3,"romance","romance",500);
  }
  retrieveAllRomances() {
    return this.#romances;
  }
}
