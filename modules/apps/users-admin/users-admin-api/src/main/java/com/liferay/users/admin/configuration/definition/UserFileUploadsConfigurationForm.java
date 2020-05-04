/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.configuration.definition;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;

/**
 * @author Pei-Jung Lan
 */
@DDMForm
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.SINGLE_PAGE_MODE,
	value = {
		@DDMFormLayoutPage(
			{
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"imageCheckToken", "imageDefaultUseInitials",
								"imageMaxSize"
							}
						)
					}
				),
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 6, value = "imageMaxHeight"
						),
						@DDMFormLayoutColumn(size = 6, value = "imageMaxWidth")
					}
				)
			}
		)
	}
)
public interface UserFileUploadsConfigurationForm {

	@DDMFormField(
		label = "%check-token", properties = "showAsSwitcher=true",
		tip = "%users-image-check-token-help"
	)
	public boolean imageCheckToken();

	@DDMFormField(
		label = "%use-initials-for-default-user-portrait",
		properties = "showAsSwitcher=true",
		tip = "%use-initials-for-default-user-portrait-help"
	)
	public boolean imageDefaultUseInitials();

	@DDMFormField(
		label = "%maximum-height", tip = "%users-image-maximum-height-help"
	)
	public int imageMaxHeight();

}