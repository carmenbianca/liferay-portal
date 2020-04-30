/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-search-sort-configuration',
	A => {
		var SortConfiguration = function(form) {
			var instance = this;

			instance.form = form;

			instance.form.on('submit', A.bind(instance._onSubmit, instance));
		};

		A.mix(SortConfiguration.prototype, {
			_onSubmit(event) {
				var instance = this;

				event.preventDefault();

				var fields = [];

				var fieldFormRows = A.all('.field-form-row').filter(item => {
					return !item.get('hidden');
				});

				fieldFormRows.each(item => {
					var label = item.one('.label-input').val();

					var field = item.one('.sort-field-input').val();

					fields.push({
						field,
						label,
					});
				});

				instance.form.one('.fields-input').val(JSON.stringify(fields));

				submitForm(instance.form);
			},
		});

		Liferay.namespace('Search').SortConfiguration = SortConfiguration;
	},
	'',
	{
		requires: ['aui-node'],
	}
);
