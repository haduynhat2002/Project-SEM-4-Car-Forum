package com.example.carforum.entity;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    @NotEmpty(message ="Vui lòng nhập tên")
//    @Size(min = 2, max = 30, message = "Tên của bạn phải nhiều hơn 2 lí tự và không quá 30 kí tự")
    private String fullname;

//    @NotEmpty(message ="Vui lòng nhập tên")
    private String userName;


    @NotEmpty(message ="Vui lòng chọn giới tính")
    private String gender;

    @NotEmpty(message = "Không được để trống")
    private String dob;

//    @NotNull(message = "Vui lòng nhập Email")
    @NotEmpty(message ="Vui lòng nhập đúng Email")
    private String email;

    @NotEmpty(message = "Vui lòng nhập số điện thoại")
//    @Size(max = 10, min = 10, message = "Số điện thoại phải có 10 chữ số")
//    @Pattern(regexp = "[7-9][0-9]{9}", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotEmpty(message = "Vui lòng nhập ảnh đại diện")
    private String avatar;

    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String address;

//    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
//            message = "Enter valid password")
    @NotEmpty(message = "Vui lòng nhập mật khẩu")
    private String password;
    private int status;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();
}
