/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const withContextMock = Component => {
	return class WithContextMock extends Component {
		getChildContext() {
			return {
				store: {
					editingLanguageId: 'en_US',
				},
			};
		}
	};
};

export default withContextMock;
