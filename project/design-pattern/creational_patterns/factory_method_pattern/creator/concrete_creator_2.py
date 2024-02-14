from creational_patterns.factory_method_pattern.creator.abstract_creator import Creator
from creational_patterns.factory_method_pattern.product.abstract_product import Product
from creational_patterns.factory_method_pattern.product.concrete_product_2 import ConcreteProduct2


class ConcreteCreator2(Creator):

    def factory_method(self) -> Product:
        return ConcreteProduct2()
