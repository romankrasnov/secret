package com.smallredtracktor.yourpersonaleducationalapplication.main.MVPproviders;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.MotionEvent;

import com.smallredtracktor.yourpersonaleducationalapplication.main.DataObjects.POJOs.OcrResponseModel;
import com.smallredtracktor.yourpersonaleducationalapplication.main.DataObjects.TestItem;
import com.smallredtracktor.yourpersonaleducationalapplication.main.MVPproviders.Abstract.IAbstractModel;
import com.smallredtracktor.yourpersonaleducationalapplication.main.MVPproviders.Abstract.IAbstractPresenter;
import com.smallredtracktor.yourpersonaleducationalapplication.main.MVPproviders.Abstract.IAbstractView;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;


public interface ICreateTestFragmentMVPprovider {

    interface IPresenter extends IAbstractPresenter
    {
        void setView(IFragment view);
        void onAddQuestionClick();
        void onQuestionPressed(String id);
        void onGalleryResult(Uri path, int type, boolean isQuestion);
        void onBackPressed();
        void onPhotoTaken(String mPath, int type, boolean isQuestion);
        void rxUnsubscribe();
        void onViewResumed(String s, String ticketId);
        void onAnswerViewSwipe(String id);
        boolean onQuestionLongPressed(String id);
        void onAnswerPageSelected(int page, int count);
        void onViewModeChanged(boolean isFullScreenMode);
        void onAnswerDoubleTap(String id);
        void onAnswerFragmentClick(String id);
        void onAnswerScroll(String id, MotionEvent e2);
        void onAnswerDown(String id, MotionEvent e);
        void onAnswerFragmentUp(String id, MotionEvent event);
    }

    interface IFragment extends IAbstractView
    {
        void setCounterTextView(String s);
        void showToast(String msg);
        void setTextQuestion(String id, int type, String value);
        void setPhotoQuestion(String id, int type, Bitmap content);
        void setCurrentAnswer(String id, int type, String value);
        void addNewAnswer();
        void removeAnswer(String id);
        void showPhotoFragment(String id, String value, int type, boolean question);
        void showTextFragment(String id, String text, int type, boolean isQuestion);
        void showCameraFragment(Intent intent, int type, boolean isQuestion, String path);
        void showGallery(int type, boolean isQuestion);
        void deleteQuestion();
        void showChooseSourceDialog(boolean b);
        void resolveCameraPermission();
        void setCurrentAnswerItem(int i);
        void switchPagerToFullScreen();
        void switchPagerToSmallView();
        void animateAnswer(String id, MotionEvent e2);
        void calculateAnswerScroll(String id, MotionEvent e);
        void scrollAnswer(String id, MotionEvent event);
        void notifyAdapterViewModeChanged(boolean isFullScreenMode);
    }

    interface IModel extends IAbstractModel
    {
        Flowable<List<TestItem>> getTestItem(String id);
        void deleteTestItem(String id);
        void deleteFile(String filepath);
        Maybe<OcrResponseModel> getParsedTextResult(String mPath);
        void updateTestItem(String id, boolean isQuestion, String currentTicket, int type, String value);
    }
}
