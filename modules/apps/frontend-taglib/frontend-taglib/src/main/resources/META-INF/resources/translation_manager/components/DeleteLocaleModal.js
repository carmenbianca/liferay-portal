/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayModal from '@clayui/modal';
import React from 'react';

export default function DeleteLocaleModal({observer, onCancel, onConfirm}) {
	return (
		<ClayModal observer={observer} size="sm">
			<ClayModal.Body>
				<h4>
					{Liferay.Language.get(
						'are-you-sure-you-want-to-deactivate-this-language'
					)}
				</h4>
			</ClayModal.Body>
			<ClayModal.Footer
				last={
					<ClayButton.Group spaced>
						<ClayButton displayType="secondary" onClick={onCancel}>
							{Liferay.Language.get('dismiss')}
						</ClayButton>
						<ClayButton onClick={onConfirm}>
							{Liferay.Language.get('delete')}
						</ClayButton>
					</ClayButton.Group>
				}
			/>
		</ClayModal>
	);
}
