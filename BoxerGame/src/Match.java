public class Match {
    Fighter f1;
    Fighter f2;
    int minweight;
    int maxweight;

    Match(Fighter f1, Fighter f2, int minweight, int maxweight){
        this.f1 = f1;
        this.f2 = f2;
        this.minweight = minweight;
        this.maxweight = maxweight;
    }
    void StartRun(){
        if (f1.IsHit()){
            run(f1, f2);
        }else{
            run(f2,f1);
        }
    }


    void run(Fighter f1, Fighter f2){
        if(IsCheck()){
            while(this.f1.health > 0 && this.f2.health > 0)
            {
                System.out.println(" ");
                System.out.println("=====New Game======");
                this.f2.health = this.f1.hit(this.f2);
                if (IsWin()){
                    break;
                }

                this.f1.health = this.f2.hit(f1);
                if (IsWin()){
                    break;
                }
                System.out.println(f1.name + " Health: " + this.f1.health);
                System.out.println(f2.name + " Health: " + this.f2.health);
                System.out.println(" ");
            }
        }else{
            System.out.println("Boxers weight doesn't match!");
        }
    }

    boolean IsCheck(){
        return (this.f1.weight >= minweight && this.f1.weight <= maxweight) && (this.f2.weight >= minweight && this.f2.weight <= maxweight);
    }

    boolean IsWin(){
        if (this.f1.health == 0){
            System.out.println(f2.name + " won!");
            return true;
        }

        if (this.f2.health == 0){
            System.out.println(f1.name + " won!");
            return true;
        }
        return false;
    }
}
