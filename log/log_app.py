import logging

class LogApp :

    def __init__(self,filename):
        self.app = logging.getLogger(filename)
        # create logger
        self.app = logging.getLogger(filename)
        # set log level
        self.app.setLevel(logging.DEBUG)
        # set log format
        consoleHandler = logging.StreamHandler()
        formatter = logging.Formatter('%(asctime)s - %(filename)s - %(levelname)s - %(message)s')
        consoleHandler.setFormatter(formatter)
        self.app.addHandler(consoleHandler)

# LogApp(__file__).app.debug("Test")