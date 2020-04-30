/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export default Component => {
	return class withRepeatableFields extends Component {
		remove() {
			this.dispatch('fieldRemoved', this.name);
		}

		repeat() {
			this.dispatch('fieldRepeated', this.name);
		}

		_handleAddRepeatedFieldButtonClicked() {
			this.repeat();
		}

		_handleRemoveRepeatedFieldButtonClicked() {
			this.remove();
		}
	};
};
