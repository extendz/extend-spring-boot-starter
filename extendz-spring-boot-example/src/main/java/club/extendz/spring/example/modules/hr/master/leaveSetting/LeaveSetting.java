/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package club.extendz.spring.example.modules.hr.master.leaveSetting;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.envers.Audited;

import club.extendz.spring.example.modules.hr.master.enums.Day;
import lombok.Getter;
import lombok.Setter;

/***
 * @author Asitha Niranjan (asitha93@live.com)
 */
@Entity
@Getter
@Setter
@Audited
public class LeaveSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	// leave eligibility cycle
	private Integer carryForwardLimit;
	private Float encashment;
	private Boolean minimumServiceRequired;
	private Float perDaySalaryMultiplier;
	private Float perDaySalaryDivisor;
	// annual leave eligibility service
	@ElementCollection(targetClass = Day.class)
	@CollectionTable(name = "leaveSetting_eligibleDays", joinColumns = @JoinColumn(name = "leaveSetting_id"))
	@Column(name = "day_id")
	private Set<Day> eligibleDays;
	private Boolean grayuityServiceRequired;
	private Float perDaySalaryDivisorForGratuity;
	private Boolean proportionalEligibility;
	// service required for gratuity
	@ElementCollection(targetClass = Day.class)
	@CollectionTable(name = "leaveSetting_ligibleDaysForGratuity", joinColumns = @JoinColumn(name = "leaveSetting_id"))
	@Column(name = "day_id")
	private Set<Day> eligibleDaysForGratuity;

}
