/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export default (...functions) =>
	functions.reduce((a, c) => (...args) => a(c(...args)));
