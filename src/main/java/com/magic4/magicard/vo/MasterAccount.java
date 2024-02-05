package com.magic4.magicard.vo;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MasterAccount {
  /*
   * @Id
   * 
   * @NonNull
   * private String companyId;
   */

  // @Id
  // private String companyTicker;

  // @OneToOne(mappedBy="masterAccount")
  // private Company company;

  // @NonNull
  @Id
  private String masterAccountId;

  @NonNull
  private String masterAccountPassword;

  @UpdateTimestamp
  private Timestamp createTime;

  @ColumnDefault("false")
  private boolean isDelegate;

  @ColumnDefault("false")
  private boolean isApproved;

  @OneToOne
  @JoinColumn(name = "register_id")
  private CompanyRegisterRequest companyRegisterRequest;

  // master_account는 고객사 관리자가 회사 계정을 등록하기 위함.
  // company_register_request의 is_pass가 true로 수정되면 master_account 생성된다.
  // 1개의 master_account는 1개의 register_id를 참조

  /*
   * 여기에 company column은 생기는 것이 아님
   * 
   * masterAccount라는 column에 mapped 된 것임
   */

  // company table에서도 company_id를 pk로 사용
}
