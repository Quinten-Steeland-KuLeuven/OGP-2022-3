/**
 * A class for a transmogrifier.
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */
public class Transmogrifier extends Device {

    State state;

    /**
     * Function to set the state of the output of the transmogrifier.
     * @param   state
     *          The state of the output of the transmogrifier
     */
    public void setState(State state) {
        this.state = state;
    }

    public void execute() {

    }
}
