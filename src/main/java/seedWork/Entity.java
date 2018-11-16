package seedWork;

public abstract class Entity {
	public void ThrowExceptionIfAny(Notification notification)
    {
        if (notification.hasErrors())
        {
            throw new IllegalArgumentException(notification.errorMessage());
        }
    }
}
