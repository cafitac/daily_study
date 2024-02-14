from creational_patterns.factory_method_pattern.creator.abstract_creator import Creator
from creational_patterns.factory_method_pattern.creator.concrete_creator_1 import ConcreteCreator1
from creational_patterns.factory_method_pattern.creator.concrete_creator_2 import ConcreteCreator2


def client_code(creator: Creator) -> None:

    print(f"Client: I'm not aware of the creator's class, but it still works.\n"
          f"{creator.operation()}", end="")


if __name__ == "__main__":
    print("App: Launched with the ConcreteCreator1.")
    client_code(ConcreteCreator1())
    print("\n")

    print("App: Launched with the ConcreteCreator2.")
    client_code(ConcreteCreator2())
