/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export default Component => {
	return class withDispatch extends Component {
		dispatch(...args) {
			const {dispatch} = this.context;

			(dispatch || this.emit).apply(this, args);
		}
	};
};
