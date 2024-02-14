from abc import ABC, abstractmethod

from creational_patterns.factory_method_pattern.product.abstract_product import Product


class Creator(ABC):

    @abstractmethod
    def factory_method(self) -> Product:
        pass

    def operation(self) -> str:
        product: Product = self.factory_method()

        result = f"msg: {product.operation()}"

        return result
