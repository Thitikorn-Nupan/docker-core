from entity.book import Book
# from log.log_app import LogApp


class BookService :

    __bookList : list[Book]

    def __init__(self):
        self.__bookList : list[Book] = []
        self.__bookList.insert(0,Book(1,'Java Core 2023',1500,300.00,True,'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.').__dict__)
        self.__bookList.insert(1,Book(2,'Python Core 2023',1500,350.00,True,'Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation.').__dict__)
        self.__bookList.insert(2,Book(3,'C++ Core 2023',1500,300.00,True,'C++ is an object-oriented programming (OOP) language that is viewed by many as the best language for creating large-scale applications.').__dict__)

    def getBookList(self):
        return self.__bookList

    """
    def getBookById(self,id:int):
        for book in self.__bookList:
            if book.id == id :
                return book
        return None # None is null

    def saveBook(self,book:Book):
        size = len(self.__bookList)
        # not a good logic
        lastBook : Book = self.__bookList[-1] # get last element
        book.id = lastBook.id + 1
        self.__bookList.insert(int(size),book)
        return size is not len(self.__bookList)

    def editBookById(self,id:int,book:Book):
        for bookHold in self.__bookList:
            if bookHold.id == id :
               bookHold.name = book.name
               bookHold.price = book.price
               bookHold.des = book.des
               bookHold.amount = book.amount
               bookHold.status = book.status
               return True
        return False

    def removeBookById(self,id:int):
        for bookHold in self.__bookList:
            if bookHold.id == id :
                self.__bookList.remove(bookHold)
                return True
        return False
    """

"""
log = LogApp(__file__)
log.app.debug(BookService().getBookList()[0].__dict__)
"""

