package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.model.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private ServletContext servletContext;

    @RequestMapping
    public String home() {
        return "home";
    }

    @GetMapping("/upload")
    private String upload(Model model) {
        model.addAttribute("uploadModel", new UploadModel());
        return "upload";
    }

    @PostMapping("/upload") //xử lý request POST đến"/upload"
    public String doUpload(@ModelAttribute("uploadModel") UploadModel uploadModel, Model model) {
        String single = "";
        List<String> multiple = new ArrayList<>();

        // xử lý upload 1 file
        String path = servletContext.getRealPath("/uploads"); // Lấy đường dẫn thực tế đến thư mục uploads trên server
        File file = new File(path); // Tạo File với đường dẫn đã lấy

        if (!file.exists()) { // nếu thư mục không tồn tại
            file.mkdirs(); // Tạo mới thư mục uploads
        }

        single = uploadFile(uploadModel.getSingle(), path); // Gọi uploadFile để upload file đơn và lưu đường dẫn vào biến single

        for (MultipartFile f : uploadModel.getMultiple()) { // Duyệt qua từng file trong danh sách file nhiều
            String uploadPath = uploadFile(f, path);
            multiple.add(uploadPath); // Thêm đường dẫn file đã upload vào danh sách multiple
        }

        model.addAttribute("one", single); // Thêm đường dẫn file đơn vào mô hình để sử dụng trong view
        model.addAttribute("many", multiple);
        return "image";
    }


    private String uploadFile(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();// lấy ra tên file upload
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path + File.separator + fileName));
            // file.getBytes(): Lấy nội dung của file đã upload(dưới dạng mảng byte).
            // new File(path + File.separator + fileName)Tạo một File mới với đường dẫn là path (thư mục lưu trữ trên server) + (fileName)
            // sao chép nội dung từ mảng byte ( lấy từ file upload) vào vị trí mới mà đối tượng File đã chỉ định. Tức thực hiện lưu file đã upload vào thư mục đã chỉ định trên server.
            // --> lưu nội dung của file đã upload vào một file mới trên server tại vị trí được chỉ định.
            return "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/data-binding")
    public String dataBinding(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listcheck", Arrays.asList("apple", "orrange", "grapes"));
        return "dataBinding";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("person") Person person, Model model) {
        model.addAttribute("obj", person);
        return "result-add-person";
    }

    @RequestMapping("/mail-config")
    public String mailConfig(Model model) {
        model.addAttribute("mailConfig", new MailConfig());
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", Arrays.asList(5,10,15,20,25,50,100));
        return "mailConfig";
    }

    @PostMapping("/createMail")
    public String createMail(@ModelAttribute("mailConfig") MailConfig mailConfig, Model model) {
model.addAttribute("config", mailConfig);
return "resultMail";
    }


    private static List<Song> songList = new ArrayList<>();
    @RequestMapping("/up-music")
    public String upMusic(Model model) {
model.addAttribute("song", new Song());
return  "upload-music";
    }

    @PostMapping("/uploaded-music")
public String doUploadedMusic(@ModelAttribute("song") Song song, Model model, MultipartFile file) {
        // Lưu bài hát vào danh sách
        String filePath = "/uploads/" + file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath));
            song.setSource(filePath);
            songList.add(song);
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi upload file.");
            throw new RuntimeException(e);
        }
        return "redirect:/list-music";
    }

    @RequestMapping("/list-music")
    public String listMusic(Model model) {
        model.addAttribute("songs", songList); // Truyền danh sách bài hát
        return "list-music";
    }



    private Medical medicalData = new Medical(); // Đơn giản hóa lưu trữ dữ liệu
    @RequestMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medical", new Medical());
        return "add-medical";
    }

    @PostMapping("/added")
    public String submitForm(@Valid Medical medical, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Nếu có lỗi, thêm thông báo vào model
            model.addAttribute("errorMessage", "Vui lòng điền tất cả thông tin.");
            return "add-medical";
        }
        this.medicalData = medical;
//        return "redirect:/display-medical";
        return "redirect:/display";
    }

    @RequestMapping("/display")
    public String displayInfo(Model model) {
        model.addAttribute("medical", medicalData);
        return "display-medical";
    }

    @RequestMapping("/update")
    public String showUpdateForm(Model model) {
        model.addAttribute("medical", medicalData);
        return "update-medical";
    }

    @PostMapping("/updated")
    public String updateForm(@Valid Medical medical, BindingResult result) {
        if (result.hasErrors()) {
            return "update-medical";
        }
        this.medicalData = medical;
//        return "redirect:/display-medical";
        return "redirect:/display";
    }
}
