package com.example.jewelryshop;

import android.content.res.Resources;

public class Jewel {

    private boolean signed;
    private int type, material, ore;
    private int totalPrice;
    private Resources resources;

    public Jewel(boolean signed, int type, int material, int ore) {
        this.signed = signed;
        this.type = type;
        this.material = material;
        this.ore = ore;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void generatePrice(){
        int total = 0;
        if (this.getType() == 1){
            switch (this.getMaterial()){
                case 1:
                    total += 50000;
                    break;
                case 2:
                    total += 30000;
                    break;
                case 3:
                    total += 90000;
                    break;
                default:
                    total += 0;
                    break;
            }
            switch (this.getOre()){
                case 1:
                    total += 190000;
                    break;
                case 2:
                    total += 180000;
                    break;
                case 3:
                    total += 150000;
                    break;
                default:
                    total += 0;
                    break;
            }

        } else if(this.getType() == 2){
            switch (this.getMaterial()){
                case 1:
                    total += 100000;
                    break;
                case 2:
                    total += 50000;
                    break;
                case 3:
                    total += 150000;
                    break;
                default:
                    total += 0;
                    break;
            }
            switch (this.getOre()){
                case 1:
                    total += 190000;
                    break;
                case 2:
                    total += 180000;
                    break;
                case 3:
                    total += 150000;
                    break;
                default:
                    total += 0;
                    break;
            }
        }
        this.setTotalPrice(total);
    }

    public void saveOrder(){
        this.generatePrice();
        ShoppingCart.addToCart(this);
    }


}
