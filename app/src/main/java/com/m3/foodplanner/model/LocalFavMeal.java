package com.m3.foodplanner.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "FavMeal")
public class LocalFavMeal {

    @PrimaryKey
    @NonNull
    private String mealID;
    @ColumnInfo(name ="mealTitle")

    private String strMeal;



    @ColumnInfo(name ="mealInstructions")

    private  String strInstructions;
    @ColumnInfo(name ="MealThumb")

    private String strMealThumb;
    @ColumnInfo(name ="youTubeLink")

    private String strYoutube;
    private String strIngredien1;
    private String strIngredien2;
    private String strIngredien3;
    private String strIngredien4;
    private String strIngredien5;
    private String strIngredien6;
    private String strIngredien7;
    private String strIngredien8;
    private String strIngredien9;
    private String strIngredien10;
    private String strIngredien11;
    private String strIngredien12;
    private String strIngredien13;
    private String strIngredien14;
    private String strIngredien15;
    private String strIngredien16;
    private String strIngredien17;
    private String strIngredien18;
    private String strIngredien19;
    private String strIngredien20;

    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;

    public LocalFavMeal(@NonNull String mealID, String strMeal, String strInstructions, String strMealThumb, String strYoutube, String strIngredien1, String strIngredien2, String strIngredien3, String strIngredien4, String strIngredien5, String strIngredien6, String strIngredien7, String strIngredien8, String strIngredien9, String strIngredien10, String strIngredien11, String strIngredien12, String strIngredien13, String strIngredien14, String strIngredien15, String strIngredien16, String strIngredien17, String strIngredien18, String strIngredien19, String strIngredien20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20) {
        this.mealID = mealID;
        this.strMeal = strMeal;

        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strYoutube = strYoutube;

        this.strIngredien1 = strIngredien1;
        this.strIngredien2 = strIngredien2;
        this.strIngredien3 = strIngredien3;
        this.strIngredien4 = strIngredien4;
        this.strIngredien5 = strIngredien5;
        this.strIngredien6 = strIngredien6;
        this.strIngredien7 = strIngredien7;
        this.strIngredien8 = strIngredien8;
        this.strIngredien9 = strIngredien9;
        this.strIngredien10 = strIngredien10;
        this.strIngredien11 = strIngredien11;
        this.strIngredien12 = strIngredien12;
        this.strIngredien13 = strIngredien13;
        this.strIngredien14 = strIngredien14;
        this.strIngredien15 = strIngredien15;
        this.strIngredien16 = strIngredien16;
        this.strIngredien17 = strIngredien17;
        this.strIngredien18 = strIngredien18;
        this.strIngredien19 = strIngredien19;
        this.strIngredien20 = strIngredien20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
    }

    @NonNull
    public String getMealID() {
        return mealID;
    }

    public void setMealID(@NonNull String mealID) {
        this.mealID = mealID;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }



    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrIngredien1() {
        return strIngredien1;
    }

    public void setStrIngredien1(String strIngredien1) {
        this.strIngredien1 = strIngredien1;
    }

    public String getStrIngredien2() {
        return strIngredien2;
    }

    public void setStrIngredien2(String strIngredien2) {
        this.strIngredien2 = strIngredien2;
    }

    public String getStrIngredien3() {
        return strIngredien3;
    }

    public void setStrIngredien3(String strIngredien3) {
        this.strIngredien3 = strIngredien3;
    }

    public String getStrIngredien4() {
        return strIngredien4;
    }

    public void setStrIngredien4(String strIngredien4) {
        this.strIngredien4 = strIngredien4;
    }

    public String getStrIngredien5() {
        return strIngredien5;
    }

    public void setStrIngredien5(String strIngredien5) {
        this.strIngredien5 = strIngredien5;
    }

    public String getStrIngredien6() {
        return strIngredien6;
    }

    public void setStrIngredien6(String strIngredien6) {
        this.strIngredien6 = strIngredien6;
    }

    public String getStrIngredien7() {
        return strIngredien7;
    }

    public void setStrIngredien7(String strIngredien7) {
        this.strIngredien7 = strIngredien7;
    }

    public String getStrIngredien8() {
        return strIngredien8;
    }

    public void setStrIngredien8(String strIngredien8) {
        this.strIngredien8 = strIngredien8;
    }

    public String getStrIngredien9() {
        return strIngredien9;
    }

    public void setStrIngredien9(String strIngredien9) {
        this.strIngredien9 = strIngredien9;
    }

    public String getStrIngredien10() {
        return strIngredien10;
    }

    public void setStrIngredien10(String strIngredien10) {
        this.strIngredien10 = strIngredien10;
    }

    public String getStrIngredien11() {
        return strIngredien11;
    }

    public void setStrIngredien11(String strIngredien11) {
        this.strIngredien11 = strIngredien11;
    }

    public String getStrIngredien12() {
        return strIngredien12;
    }

    public void setStrIngredien12(String strIngredien12) {
        this.strIngredien12 = strIngredien12;
    }

    public String getStrIngredien13() {
        return strIngredien13;
    }

    public void setStrIngredien13(String strIngredien13) {
        this.strIngredien13 = strIngredien13;
    }

    public String getStrIngredien14() {
        return strIngredien14;
    }

    public void setStrIngredien14(String strIngredien14) {
        this.strIngredien14 = strIngredien14;
    }

    public String getStrIngredien15() {
        return strIngredien15;
    }

    public void setStrIngredien15(String strIngredien15) {
        this.strIngredien15 = strIngredien15;
    }

    public String getStrIngredien16() {
        return strIngredien16;
    }

    public void setStrIngredien16(String strIngredien16) {
        this.strIngredien16 = strIngredien16;
    }

    public String getStrIngredien17() {
        return strIngredien17;
    }

    public void setStrIngredien17(String strIngredien17) {
        this.strIngredien17 = strIngredien17;
    }

    public String getStrIngredien18() {
        return strIngredien18;
    }

    public void setStrIngredien18(String strIngredien18) {
        this.strIngredien18 = strIngredien18;
    }

    public String getStrIngredien19() {
        return strIngredien19;
    }

    public void setStrIngredien19(String strIngredien19) {
        this.strIngredien19 = strIngredien19;
    }

    public String getStrIngredien20() {
        return strIngredien20;
    }

    public void setStrIngredien20(String strIngredien20) {
        this.strIngredien20 = strIngredien20;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }
}
