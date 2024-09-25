package ra.orm.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.model.Song;

@Component
public class SongValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Song.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;

        // Kiểm tra không được để trống songName
        if (song.getSongName() == null || song.getSongName().trim().isEmpty()) {
            errors.rejectValue("songName", null, "Không được phép để trống tên bài hát");
        } else if (song.getSongName().length() > 800) {
            errors.rejectValue("songName", null, "Tên bài hát không được vượt quá 800 ký tự");
        } else if (!song.getSongName().matches("^[A-Za-z0-9\\s,]+$")) {
            errors.rejectValue("songName", null, "Tên bài hát không được chứa ký tự đặc biệt");
        }

        // Kiểm tra không được để trống singerName
        if (song.getSingerName() == null || song.getSingerName().trim().isEmpty()) {
            errors.rejectValue("singerName", null, "Không được phép để trống tên ca sĩ");
        } else if (song.getSingerName().length() > 300) {
            errors.rejectValue("singerName", null, "Tên ca sĩ không được vượt quá 300 ký tự");
        } else if (!song.getSingerName().matches("^[A-Za-z0-9\\s,]+$")) {
            errors.rejectValue("singerName", null, "Tên ca sĩ không được chứa ký tự đặc biệt");
        }

        // Kiểm tra không được để trống genre
        if (song.getGenre() == null || song.getGenre().trim().isEmpty()) {
            errors.rejectValue("genre", null, "Không được phép để trống thể loại");
        } else if (song.getGenre().length() > 1000) {
            errors.rejectValue("genre", null, "Thể loại không được vượt quá 1000 ký tự");
        } else if (!song.getGenre().matches("^[A-Za-z0-9\\s,]+$")) {
            errors.rejectValue("genre", null, "Thể loại không được chứa ký tự đặc biệt (ngoại trừ dấu phẩy)");
        }
    }
}
