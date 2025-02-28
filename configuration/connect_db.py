import mysql.connector as mysql
from mysql.connector.aio import MySQLConnectionAbstract

from log.log_app import LogApp

log = LogApp(__file__)


class ConnectDB:
    connect: MySQLConnectionAbstract  # decare empty attribute MySQLConnectionAbstract type

    def __init__(self):
        log.app.debug("ConnectDB class was initial now connect already use")
        self.__initialConnect()

    def __initialConnect(self):
        # can connect on docker
        # can't connect on local to docker
            self.connect = mysql.connect(
                host='database', # host mysql on container
                database='to_do_apps_docker',
                user='ttknp',
                password='12345',
                port='3306' # port mysql on container because i connect inside not remote
            )


"""
connectDatabase = ConnectDB()
cr : MySQLConnectionAbstract = connectDatabase.connect.cursor()
cr.execute("show tables;")
for table in cr:
    print(table)
cr.close()
"""
connectDatabase = ConnectDB()
cr : MySQLConnectionAbstract = connectDatabase.connect.cursor()
cr.execute("show tables;")
for table in cr:
    log.app.debug(table)
cr.close()
