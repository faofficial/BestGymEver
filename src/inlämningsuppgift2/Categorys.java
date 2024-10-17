package inlämningsuppgift2;

public enum Categorys
{
        CUSTOMER("Kunden är en nuvarande medlem"),
        FORMER_CUSTOMER("Det här är en före detta kund"),
        UNAUTHORIZED("Den här personen är obehörig");

        public final String label;
        Categorys(String condition)
        {
            label = condition;
        }
}
