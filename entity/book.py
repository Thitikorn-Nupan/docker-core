from dataclasses import dataclass
# from log.log_app import LogApp

@dataclass
class Book:
    def __init__(self,id:int,name:str,amount:int,price:int,status:bool,des:str):
        self.id = id
        self.name = name
        self.amount = amount
        self.price = price
        self.status = status
        self.des = des

    @property
    def _amount(self):
        return self.amount

    @_amount.setter
    def _amount(self, value):
        self.amount = value

    @property
    def _des(self):
        return self.des

    @_des.setter
    def _des(self, value):
        self.des = value

    @property
    def _price(self):
        return self.price

    @_price.setter
    def _price(self, value):
        self.price = value

    @property
    def _name(self):
        return self.name

    @_name.setter
    def _name(self, value):
        self.name = value

    @property
    def _id(self):
        return self.id

    @_id.setter
    def _id(self, value):
        self.id = value

    @property
    def _status(self):
        return self.status

    @_status.setter
    def _status(self, value):
        self.status = value


"""
log = LogApp(__file__)
log.app.debug(Book(1,'Java Core 2023',1500,300.00,True,'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.').__dict__)
"""
