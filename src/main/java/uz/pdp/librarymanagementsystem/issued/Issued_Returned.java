package uz.pdp.librarymanagementsystem.issued;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issued_Returned {
    private Integer id;
    private String title;
    private String fullName;
    private String date;
    private String issued;
    private Integer userId;
    private Integer bookId;
}
