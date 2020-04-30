/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import React from 'react';

export default ({
	body,
	callback,
	onClose,
	status = 'info',
	textPrimaryButton = 'Save',
	textSecondaryButton = 'Cancel',
	title,
	visible,
}) => {
	const {observer, onClose: close} = useModal({
		onClose,
	});

	return (
		<>
			{visible && (
				<ClayModal observer={observer} status={status}>
					<ClayModal.Header>{title}</ClayModal.Header>
					<ClayModal.Body>{body}</ClayModal.Body>
					<ClayModal.Footer
						first={
							<ClayButton displayType="secondary" onClick={close}>
								{textSecondaryButton}
							</ClayButton>
						}
						last={
							<ClayButton
								displayType="primary"
								onClick={() => {
									callback();
									close();
								}}
							>
								{textPrimaryButton}
							</ClayButton>
						}
					/>
				</ClayModal>
			)}
		</>
	);
};
