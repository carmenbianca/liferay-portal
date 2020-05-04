/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {Config} from 'metal-state';

export default Component => {
	class WithLocale extends Component {
		prepareStateForRender(states) {
			const {editingLanguageId} = this.context.store;
			const languageValues = [];

			Object.keys(this.localizedValue).forEach(key => {
				if (key !== editingLanguageId) {
					languageValues.push({
						name: this.name.replace(editingLanguageId, key),
						value: this.localizedValue[key],
					});
				}
			});

			return {
				...super.prepareStateForRender(states),
				_localizedValue: languageValues,
			};
		}
	}

	WithLocale.STATE = {
		_localizedValue: Config.arrayOf(
			Config.shapeOf({
				name: Config.string(),
				value: Config.any(),
			})
		).value([]),

		localizedValue: Config.object().value({}),
	};

	return WithLocale;
};
