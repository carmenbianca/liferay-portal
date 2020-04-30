/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEventListener} from 'frontend-js-react-web';
import {openToast} from 'frontend-js-web';
import React, {useEffect, useState} from 'react';

import {SERVICE_NETWORK_STATUS_TYPES} from '../config/constants/serviceNetworkStatusTypes';

const getStatus = (isOnline, status, lastSaveDate) => {
	if (!isOnline) {
		return `${Liferay.Language.get('trying-to-reconnect')}...`;
	}
	else if (status === SERVICE_NETWORK_STATUS_TYPES.savingDraft) {
		return Liferay.Language.get('saving-changes');
	}
	else if (lastSaveDate) {
		return lastSaveDate;
	}

	return null;
};

const parseDate = date => {
	if (!date) {
		return null;
	}

	const lastSaveDateText = Liferay.Language.get('changes-saved');

	return lastSaveDateText.replace(
		'{0}',
		date.toLocaleTimeString(Liferay.ThemeDisplay.getBCP47LanguageId())
	);
};

const NetworkStatusBar = ({error, lastFetch, status}) => {
	const [isOnline, setIsOnline] = useState(true);
	const [lastSaveDate, setLastSaveDate] = useState(parseDate(lastFetch));

	useEffect(() => {
		setLastSaveDate(parseDate(lastFetch));
	}, [lastFetch]);

	useEffect(() => {
		if (status === SERVICE_NETWORK_STATUS_TYPES.error) {
			openToast({
				message: error,
				title: Liferay.Language.get('error'),
				type: 'danger',
			});
		}
	}, [error, status]);

	useEventListener('online', () => setIsOnline(true), true, window);

	useEventListener('offline', () => setIsOnline(false), true, window);

	const statusText = getStatus(isOnline, status, lastSaveDate);

	if (!statusText) {
		return null;
	}

	return (
		<li className="d-inline nav-item text-truncate">
			<span className="my-0 navbar-text" data-title={statusText}>
				{statusText}
			</span>
		</li>
	);
};

export default NetworkStatusBar;
