package service;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    public List<Product> productList = Arrays.asList(
            new Product(1, "Quan kaki", "mua he", 100000, "https://www.bing.com/images/search?view=detailV2&ccid=VXzdRucd&id=E128BE5E47DE494B676C00279AF69634E69E0E7F&thid=OIP.VXzdRucdbUg_h06hMWoJTQHaJ3&mediaurl=https%3A%2F%2Flaforce.vn%2Fwp-content%2Fuploads%2F2022%2F07%2Fphoi-quan-kaki-nam.jpg&cdnurl=https%3A%2F%2Fth.bing.com%2Fth%2Fid%2FR.557cdd46e71d6d483f874ea1316a094d%3Frik%3Dfw6e5jSW9ponAA%26pid%3DImgRaw%26r%3D0&exph=1066&expw=800&q=qu%E1%BA%A7n+kaki&simid=608008971599429766&FORM=IRPRST&ck=084F1DF051CBA48C537E1CC254B3791C&selectedIndex=7&itb=0&qpvt=qu%E1%BA%A7n+kaki&cw=503&ch=744&ajaxhist=0&ajaxserp=0"),
            new Product(2, "Quan kaki 2", "mua he", 100000, "https://www.bing.com/images/search?view=detailV2&ccid=VXzdRucd&id=E128BE5E47DE494B676C00279AF69634E69E0E7F&thid=OIP.VXzdRucdbUg_h06hMWoJTQHaJ3&mediaurl=https%3A%2F%2Flaforce.vn%2Fwp-content%2Fuploads%2F2022%2F07%2Fphoi-quan-kaki-nam.jpg&cdnurl=https%3A%2F%2Fth.bing.com%2Fth%2Fid%2FR.557cdd46e71d6d483f874ea1316a094d%3Frik%3Dfw6e5jSW9ponAA%26pid%3DImgRaw%26r%3D0&exph=1066&expw=800&q=qu%E1%BA%A7n+kaki&simid=608008971599429766&FORM=IRPRST&ck=084F1DF051CBA48C537E1CC254B3791C&selectedIndex=7&itb=0&qpvt=qu%E1%BA%A7n+kaki&cw=503&ch=744&ajaxhist=0&ajaxserp=0"),
            new Product(3, "Quan kaki 3", "mua he", 1000000, "https://www.bing.com/images/search?view=detailV2&ccid=VXzdRucd&id=E128BE5E47DE494B676C00279AF69634E69E0E7F&thid=OIP.VXzdRucdbUg_h06hMWoJTQHaJ3&mediaurl=https%3A%2F%2Flaforce.vn%2Fwp-content%2Fuploads%2F2022%2F07%2Fphoi-quan-kaki-nam.jpg&cdnurl=https%3A%2F%2Fth.bing.com%2Fth%2Fid%2FR.557cdd46e71d6d483f874ea1316a094d%3Frik%3Dfw6e5jSW9ponAA%26pid%3DImgRaw%26r%3D0&exph=1066&expw=800&q=qu%E1%BA%A7n+kaki&simid=608008971599429766&FORM=IRPRST&ck=084F1DF051CBA48C537E1CC254B3791C&selectedIndex=7&itb=0&qpvt=qu%E1%BA%A7n+kaki&cw=503&ch=744&ajaxhist=0&ajaxserp=0")
    );

    public List<Product> getAll() {
        return productList;
    }

    public Product findById(Integer id) {
        return productList.stream().filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    public void save(Product product) {
        if (findById(product.getId()) == null) {
            product.setId(getNewId());
            productList.add(product);
        }
    }

    private int getNewId(){
        // dùng stream
        // tìm ra thằng id lớn nhất + 1
        return productList.stream().map(Product::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
