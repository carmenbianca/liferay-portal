/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import React, {useEffect, useState} from 'react';

import {subscribeSection, unsubscribeSection} from '../utils/client.es';

export default ({onSubscription, section: {id, subscribed}}) => {
	const [subscription, setSubscription] = useState(false);

	useEffect(() => {
		setSubscription(subscribed);
	}, [subscribed]);

	const changeSubscription = () => {
		const promise = subscription
			? unsubscribeSection(id)
			: subscribeSection(id);
		promise.then(() => {
			setSubscription(!subscription);
			if (onSubscription) {
				onSubscription(!subscription);
			}
		});
	};

	const btnTitle = subscription
		? Liferay.Language.get('subscribed')
		: Liferay.Language.get('subscribe');

	return (
		<ClayButton
			displayType={subscription ? 'primary' : 'secondary'}
			onClick={changeSubscription}
			title={btnTitle}
		>
			<ClayIcon symbol="bell-on" />

			<span className="c-ml-2 d-none d-sm-inline-block">{btnTitle}</span>
		</ClayButton>
	);
};
