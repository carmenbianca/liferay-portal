/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import React from 'react';

import {subscribe, unsubscribe} from '../utils/client.es';

export default ({onSubscription, question}) => {
	const changeSubscription = () => {
		const promise = question.subscribed
			? unsubscribe(question.id)
			: subscribe(question.id);
		promise.then(() => {
			if (onSubscription) {
				onSubscription(!question.subscribed);
			}
		});
	};

	return (
		<ClayButton
			displayType={question.subscribed ? 'primary' : 'secondary'}
			monospaced
			onClick={changeSubscription}
		>
			<ClayIcon symbol="bell-on" />
		</ClayButton>
	);
};
