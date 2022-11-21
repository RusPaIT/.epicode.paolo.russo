class SonAccount {
    balance: number;
    constructor(_balanceInit: number = 0) {
        this.balance = _balanceInit;
    }
    deposit(amount:number) {
        this.balance += amount;
    }
    whitDraw(amount:number) {
        this.balance -= amount;
    }
}

class MotherAccount extends SonAccount {
    balance: number;
    constructor(_balanceInit:number = 0) {
        super(_balanceInit)
    }
    private addInterest() {
        this.balance = this.balance + ((this.balance*10)/100);
    }
}


var Mother = new MotherAccount(1000);
var Son = new SonAccount(500);
