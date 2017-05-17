package com.example.god.jogodamemoria;

import android.graphics.Bitmap;

/**
 * Created by god on 04/05/17.
 */

public class CardInfo {

                                private Bitmap image;
                                private String descripition;
                                private String title;

                                public CardInfo(Bitmap image, String descripition, String title) {
                                    this.image = image;
                                    this.descripition = descripition;
                                    this.title = title;
                                }
                                    public void setTitle(String title) {
                                        this.title = title;
                                    }

                                public Bitmap getImage() {
                                    return image;
                                }

                                public void setImage(Bitmap image) {
                                    this.image = image;
                                }

                                public String getDescripition() {
                                    return descripition;
                                }

                                public void setDescripition(String descripition) {
                                    this.descripition = descripition;
                                }
                                public String getTitle() {
                                    return title;
                                }


}
