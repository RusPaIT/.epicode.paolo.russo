var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var SonAccount = /** @class */ (function () {
    function SonAccount(_balanceInit) {
        if (_balanceInit === void 0) { _balanceInit = 0; }
        this.balance = _balanceInit;
    }
    SonAccount.prototype.deposit = function (amount) {
        this.balance += amount;
    };
    SonAccount.prototype.whitDraw = function (amount) {
        this.balance -= amount;
    };
    return SonAccount;
}());
var MotherAccount = /** @class */ (function (_super) {
    __extends(MotherAccount, _super);
    function MotherAccount(_balanceInit) {
        if (_balanceInit === void 0) { _balanceInit = 0; }
        return _super.call(this, _balanceInit) || this;
    }
    MotherAccount.prototype.addInterest = function () {
        this.balance = this.balance + ((this.balance * 10) / 100);
    };
    return MotherAccount;
}(SonAccount));
var Mother = new MotherAccount(1000);
var Son = new SonAccount(500);
