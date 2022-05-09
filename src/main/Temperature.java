import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class Temperature {

    private int hotness;
    private int coldness;

    private final int MAX_HOTNESS=1000;
    private final int MAX_COLDNESS=1000;

    public Temperature() {
        this(0, 0);
    }

    public Temperature(int coldness, int hotness) {
        if (coldness != 0 && hotness != 0) {
            if (coldness >= hotness) {
                coldness = 0;
            } else {
                hotness = 0;
            }
        }
        this.setColdness(coldness);
        this.setHotness(hotness);
    }

    protected int getHotness() {return this.hotness;}

    protected int getColdness() {return this.coldness;}

    private void setHotness(int hotness) {
        if ( 0 <= hotness && hotness <= this.MAX_HOTNESS)
            this.hotness = hotness;
        else
            this.hotness = 0;
    }

    private void setColdness(int coldness) {
        if ( 0 <= coldness && coldness <= this.MAX_COLDNESS)
            this.coldness = coldness;
        else
            this.coldness = 0;
    }

    public List<?> getTemperature() {
        return new ArrayList<>(Arrays.asList(this.coldness, this.hotness));
    }

}
