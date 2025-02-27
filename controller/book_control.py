from http import HTTPStatus
from flask import Flask, jsonify
from log.log_app import LogApp
## Fucking stupid error ##
# when you get error ModuleNotFoundError after run app on terminal
# The correct way to start a script that is part of a package is to use the -m (module)
# which takes a module path as an argument and executes that module as a script (but keeping the current working directory as a module search path)
# and change / to . and cut the file extension (*.py)
# example py -m controller.book_control
from service.book_service import BookService

log = LogApp(__file__)

class BookControl :

    __app: Flask
    __baseUrl: str = "/api/book"
    __bookService: BookService

    def __init__(self):
        log.app.debug("BookControl initialized")
        self.__bookService = BookService()
        self.__displayApi()

    def __displayApi(self):
        self.__app = Flask(__name__)
        log.app.debug("API initialized")

        @self.__app.route(f"{self.__baseUrl}/server", methods=['GET'])
        def testServer():
            return jsonify({
                'status': HTTPStatus.OK,
                'data': 'hello world'
            }), HTTPStatus.OK

        @self.__app.route(f"{self.__baseUrl}/reads", methods=['GET'])
        def getAllBooks():
            log.app.debug(f"{self.__baseUrl}/reads requested")
            return jsonify({
                'status': HTTPStatus.OK,
                'data': self.__bookService.getBookList()
            }), HTTPStatus.OK
        # For running Flask on Container Docker This host='localhost' is not the same as your localhost and is not served to the outside.
        # If you want to service to be available outside of the container you must listen to correct ips. like host='0.0.0.0'
        self.__app.run(host='0.0.0.0', port=8080)  # start sever

BookControl()
