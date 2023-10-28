import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Currencies {

    public static void main(String[] args) throws Exception{
        final String url = "https://tradingeconomics.com/currencies";

        try {
            final Document document = Jsoup.connect(url).get();

            for(Element row : document.select("table.table.table-hover.table-striped.table-heatmap tr")){
                if(row.select("td:nth-of-type(2)").text().isEmpty()){
                    continue;
                }else {
                final String ticker = row.select("td:nth-of-type(2)").text();
                final String price = row.select("td:nth-of-type(3)").text();
                System.out.println(ticker + " - " + price);
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
