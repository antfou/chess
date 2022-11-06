package Logic.Players;

public enum Side{

    WHITE() {
        @Override
        public int getDirection() {
            return -1;
        }
    },
    BLACK(){
        @Override
        public int getDirection() {
            return 1;
        }
    };

    public abstract int getDirection();
}