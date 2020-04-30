/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect, useState} from 'react';

import {request} from '../utils/client.es';

export default endpoint => {
	const [state, setState] = useState({
		error: null,
		isLoading: true,
		response: {},
	});

	useEffect(() => {
		request(endpoint)
			.then(response => {
				setState({
					error: null,
					isLoading: false,
					response,
				});
			})
			.catch(error => {
				setState({
					error,
					isLoading: false,
					response: {},
				});
			});
	}, [endpoint]);

	return state;
};
