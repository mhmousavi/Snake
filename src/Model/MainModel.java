package Model;

public class MainModel {
    private World world;

    public MainModel(){
        world = new World();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
