/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import {useModal} from '@clayui/modal';
import {useIsMounted} from 'frontend-js-react-web';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import ManageAllowedFragmentModal from './ManageAllowedFragmentModal';

const ManageAllowedFragmentButton = ({item}) => {
	const isMounted = useIsMounted();

	const [openModal, setOpenModal] = useState(false);

	const {observer, onClose} = useModal({
		onClose: () => {
			if (isMounted()) {
				setOpenModal(false);
			}
		},
	});

	const handleOpenModalClick = () => {
		setOpenModal(true);
	};

	return (
		<>
			{openModal && (
				<ManageAllowedFragmentModal
					item={item}
					observer={observer}
					onClose={onClose}
				/>
			)}

			<ClayButton
				displayType="secondary"
				onClick={handleOpenModalClick}
				small
			>
				{Liferay.Language.get('configure-allowed-fragments')}
			</ClayButton>
		</>
	);
};

ManageAllowedFragmentButton.propTypes = {
	item: PropTypes.object,
};

export {ManageAllowedFragmentButton};
export default ManageAllowedFragmentButton;
