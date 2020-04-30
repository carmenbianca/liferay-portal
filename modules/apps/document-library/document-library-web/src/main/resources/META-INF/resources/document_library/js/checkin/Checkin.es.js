/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useModal} from '@clayui/modal';
import React, {useState} from 'react';

import CheckinModal from './CheckinModal.es';

function Checkin({
	checkedOut,
	dlVersionNumberIncreaseValues,
	portletNamespace,
}) {
	const [showModal, setShowModal] = useState(false);
	const [callback, setCallback] = useState();
	const bridgeComponentId = `${portletNamespace}DocumentLibraryCheckinModal`;

	const handleOnClose = () => {
		setShowModal(false);
	};

	const {observer, onClose} = useModal({
		onClose: handleOnClose,
	});

	if (!Liferay.component(bridgeComponentId)) {
		Liferay.component(
			bridgeComponentId,
			{
				open: callback => {
					setCallback(() => callback);
					setShowModal(true);
				},
			},
			{
				destroyOnNavigate: true,
			}
		);
	}

	return (
		<>
			{showModal && (
				<CheckinModal
					callback={callback}
					checkedOut={checkedOut}
					dlVersionNumberIncreaseValues={
						dlVersionNumberIncreaseValues
					}
					observer={observer}
					onModalClose={onClose}
				/>
			)}
		</>
	);
}

export default function(props) {
	return (
		<Checkin {...props} portletNamespace={`_${props.portletNamespace}_`} />
	);
}
