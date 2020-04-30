/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	ADD_FRAGMENT_ENTRY_LINKS,
	ADD_FRAGMENT_ENTRY_LINK_COMMENT,
	DELETE_FRAGMENT_ENTRY_LINK_COMMENT,
	EDIT_FRAGMENT_ENTRY_LINK_COMMENT,
	UPDATE_EDITABLE_VALUES,
	UPDATE_FRAGMENT_ENTRY_LINK_CONTENT,
	UPDATE_LAYOUT_DATA,
} from '../actions/types';

export const INITIAL_STATE = {};

export default function fragmentEntryLinksReducer(
	fragmentEntryLinks = INITIAL_STATE,
	action
) {
	switch (action.type) {
		case ADD_FRAGMENT_ENTRY_LINKS: {
			const newFragmentEntryLinks = {};

			action.fragmentEntryLinks.forEach(fragmentEntryLink => {
				newFragmentEntryLinks[
					fragmentEntryLink.fragmentEntryLinkId
				] = fragmentEntryLink;
			});

			return {
				...fragmentEntryLinks,
				...newFragmentEntryLinks,
			};
		}

		case ADD_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map(comment =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: [
									...(comment.children || []),
									action.fragmentEntryLinkComment,
								],
						  }
						: comment
				);
			}
			else {
				nextComments = [...comments, action.fragmentEntryLinkComment];
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case DELETE_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map(comment =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: comment.children.filter(
									childComment =>
										childComment.commentId !==
										action.commentId
								),
						  }
						: comment
				);
			}
			else {
				nextComments = comments.filter(
					comment => comment.commentId !== action.commentId
				);
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case EDIT_FRAGMENT_ENTRY_LINK_COMMENT: {
			const fragmentEntryLink =
				fragmentEntryLinks[action.fragmentEntryLinkId];

			const {comments = []} = fragmentEntryLink;

			let nextComments;

			if (action.parentCommentId) {
				nextComments = comments.map(comment =>
					comment.commentId === action.parentCommentId
						? {
								...comment,
								children: comment.children.map(childComment =>
									childComment.commentId ===
									action.fragmentEntryLinkComment.commentId
										? action.fragmentEntryLinkComment
										: childComment
								),
						  }
						: comment
				);
			}
			else {
				nextComments = comments.map(comment =>
					comment.commentId ===
					action.fragmentEntryLinkComment.commentId
						? {...comment, ...action.fragmentEntryLinkComment}
						: comment
				);
			}

			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLink,
					comments: nextComments,
				},
			};
		}

		case UPDATE_EDITABLE_VALUES:
			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLinks[action.fragmentEntryLinkId],
					editableValues: action.editableValues,
				},
			};

		case UPDATE_FRAGMENT_ENTRY_LINK_CONTENT:
			return {
				...fragmentEntryLinks,
				[action.fragmentEntryLinkId]: {
					...fragmentEntryLinks[action.fragmentEntryLinkId],
					content: action.content,
					editableValues:
						action.editableValues ||
						fragmentEntryLinks[action.fragmentEntryLinkId]
							.editableValues,
				},
			};

		case UPDATE_LAYOUT_DATA: {
			const nextFragmentEntryLinks = {...fragmentEntryLinks};

			action.deletedFragmentEntryLinkIds.forEach(fragmentEntryLinkId => {
				delete nextFragmentEntryLinks[fragmentEntryLinkId];
			});

			action.addedFragmentEntryLinks.forEach(fragmentEntryLink => {
				nextFragmentEntryLinks[
					fragmentEntryLink.fragmentEntryLinkId
				] = fragmentEntryLink;
			});

			return nextFragmentEntryLinks;
		}

		default:
			return fragmentEntryLinks;
	}
}
