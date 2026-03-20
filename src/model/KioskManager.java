public class KioskManager {
	private int identifier; //also called ID
	//public:
	//Note: searchOutlets is not a method of Kiosk Manager because this can be used by
	//multiple actors and needs to be defined somewhere else.
	//View outlet information also should be defined somewhere else.
	//Even though these are both things that the actor KioskManager should be able to do.
};
//I considered placing these methods in KioskManager since these are uniquely
//what the store manager does, but since it requires cooperation from
//system databases, I am not sure.
//void addOutlet();
//void removeOutlet();