package polymorph_ops;

public class HDMI implements IPluggable {
    @Override
    public void connector() {
        System.out.println(this.getClass().getSimpleName()+ ": connected!");
    }
}
