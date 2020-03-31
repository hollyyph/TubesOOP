public abstract class Plant extends Element{
    private int life;
    private int price;

    public Plant(int life, int price, int x,int y){
        super(x,y);
        this.life = life;
        this.price = price;
    }

    public Plant(int life, int price, Point p){
        super(p);
        this.life = life;
        this.price = price;
    }

    public int getLife(){
        return life;
    }

    public int getPrice(){
        return price;
    }
    
    public void setLife(int life){
        this.life = life;
    }
	
    protected void shoot(int power){
        Bullet bullet = new Bullet(power,super.getOrigin().getAbsis()+1, super.getOrigin().getOrdinat());
        if (Game.addElement(bullet)){
            Game.bulletList.add(bullet);
        }

    }

    public void eaten(int power){
        if ((life-power) > power){
            setLife(getLife()-power);
        } else {
            setLife(0);
        }
        if (life == 0){
            Game.deleteElement(this);
        }
    }
}