package src.model;

public class StoreManager {
	private int StoreID;
	private int managerNumber; //The ID is first StoreID, and then managerNumber.
	//public:
	//Looking at items in this particular store is something that multiple actors may need to
	//do, so that functionality may be implemented somewhere else.
};
//I considered placing these methods in StoreManager since these are uniquely
//what the store manager actor does with the system, but since it requires
//cooperation from system databases, I am not sure.
//void addItem();
//void removeItem();
//void editItem();
