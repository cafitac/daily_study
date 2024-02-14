from creational_patterns.factory_method_pattern.product.abstract_product import Product


class ConcreteProduct2(Product):

    def operation(self) -> str:
        return "{Result of the ConcreteProduct2}"
