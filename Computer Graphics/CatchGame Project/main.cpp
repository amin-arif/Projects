#include<cstdio>
#include<iostream>
#include<string>
#include <GL/gl.h>
#include <GL/glut.h>
#include<iostream>
#include<string>
#include<windows.h>

int score = 0;
int life = 10;
bool flag = 0;
bool flag2 = 0;
int position = 0;
int ob = 0;
int ob1 = 0;
int ob2 = 0;
int ob3 = 0;
int ob4 = 0;
int ob5 = 0;
int speed = 1;
int speed2 = 3;

const int font1=(int)GLUT_BITMAP_TIMES_ROMAN_24;
const int font2=(int)GLUT_BITMAP_HELVETICA_18;
const int font3=(int)GLUT_BITMAP_HELVETICA_10;
void renderBitmapString(float x, float y, void *font,const char *string)
{
    const char *c;
    glRasterPos2f(x, y);
    for (c=string; *c != '\0'; c++) {
        glutBitmapCharacter(font, *c);
    }
}


void object(int value){
    if(ob1 < -100)
        ob1 = 0;
    ob1 -= speed;
    if(ob2 < -130)
        ob2 = -30;
    ob2 -= speed;
    if(ob3 < -160 )
        ob3 = -60;
    ob3 -= speed;
    if(ob4 < -180 )
        ob4 = -80;
    ob4 -= speed;
    if(ob5 < -200 )
        ob5 = -100;
    ob5 -= speed;

    glutPostRedisplay();
    glutTimerFunc(80, object, 0);
}

void init() {
   glClearColor(.1f,.4f,.4f,0);
}


void update(int value) {

if(position <= 0)
        position = 0;
else
    position -= speed2;
	glutPostRedisplay();
}



void update2(int value) {


if(position >= 90)
        position = 90;
else
    position += speed2;

	glutPostRedisplay();
}



void SpecialInput(int key, int x, int y)
{
switch(key)
{
case GLUT_KEY_UP:
    speed+=1;
break;
case GLUT_KEY_DOWN:
    if(speed > 1)
        speed-=1;
break;

case GLUT_KEY_LEFT:
    glutTimerFunc(100, update, 0);
break;

case GLUT_KEY_RIGHT:
    glutTimerFunc(100, update2, 0);
break;
}
glutPostRedisplay();
}

void handleKeypress(unsigned char key, int x, int y) {


	switch (key) {

    case ' ':
        flag=1;
        break;
    case 27:
        exit(0);
        break;

glutPostRedisplay();
	}
}

void homeGame()
{
    glColor3ub(255,0, 0);
    renderBitmapString(30,90,(void *)font1,"Catch Game");
    glBegin(GL_QUADS);
    glColor3b(285,0,0);
    glVertex2i(10,83);
    glVertex2i(90,83);
    glVertex2i(90,64);
    glVertex2i(10,64);
    glEnd();
    glColor3ub(255,255,255);
    renderBitmapString(15,75,(void*)font2,"Press Space Button to Start");
    renderBitmapString(15,70,(void*)font2,"Press ESC Button to Exit");

    glColor3ub(255,255,0);
    renderBitmapString(25,40,(void*)font3,"Press Left Arrow to turn Left");
    renderBitmapString(25,37,(void*)font3,"Press Right Arrow Right");
    renderBitmapString(25,34,(void*)font3,"Press Up Arrow to speed increase");
    renderBitmapString(25,31,(void*)font3,"Press Down Arrow to speed decrease");

}

void startGame() {
///score
char result[50];
    sprintf (result, "SCORE : %d", score*10);
    glColor3ub(255,255,255);
    renderBitmapString(75,95,(void *)font3,result);
///life
char arr[50];
    sprintf (arr, "LIFE : %d", life);
    glColor3ub(255,255,0);
    renderBitmapString(75,90,(void *)font3,arr);
///object 1
    glBegin(GL_QUADS);
      glColor3ub(255,128,128);
      glVertex2i(ob+47,ob1+95);
      glVertex2i(ob+52,ob1+95);
      glVertex2i(ob+52,ob1+100);
      glVertex2i(ob+47,ob1+100);
   glEnd();
   if(abs((position+5)-50)<8 && (ob1 < -100))
     score+= 1;
    else if(ob1<-100)
    {
        life--;
        if(life <= 0)
        {
            flag2 = true;
            flag = 0;
        }
    }

   ///object 2
    glBegin(GL_QUADS);
      glColor3ub(0,255,0);
      glVertex2i(ob+75,ob2+125);
      glVertex2i(ob+80,ob2+125);
      glVertex2i(ob+80,ob2+130);
      glVertex2i(ob+75,ob2+130);
   glEnd();
   if(abs((position+5)-78)<8 && (ob2 < -130))
     score+= 1;
     else if(ob2<-130)
    {
        life--;
        if(life <= 0)
        {
            flag2 = true;
            flag = 0;
        }
    }

   ///object 3
    glBegin(GL_QUADS);
      glColor3ub(255,255,0);
      glVertex2i(ob+5,ob3+155);
      glVertex2i(ob+10,ob3+155);
      glVertex2i(ob+10,ob3+160);
      glVertex2i(ob+5,ob3+160);
   glEnd();
   if(abs((position+5)-8)<8 && (ob3 < -160))
     score+= 1;
     else if(ob3<-160)
    {
        life--;
        if(life <= 0)
        {
            flag2 = true;
            flag = 0;
        }
    }

   ///object 4
    glBegin(GL_QUADS);
      glColor3ub(0,255,255);
      glVertex2i(ob+25,ob4+175);
      glVertex2i(ob+30,ob4+175);
      glVertex2i(ob+30,ob4+180);
      glVertex2i(ob+25,ob4+180);
   glEnd();
   if(abs((position+5)-28)<8 && (ob4 < -180))
     score+= 1;
     else if(ob4<-180)
    {
        life--;
        if(life <= 0)
        {
            flag2 = true;
            flag = 0;
        }
    }

   ///object 5
    glBegin(GL_QUADS);
      glColor3ub(255,0,255);
      glVertex2i(ob+90,ob5+195);
      glVertex2i(ob+95,ob5+195);
      glVertex2i(ob+95,ob5+200);
      glVertex2i(ob+90,ob5+200);
   glEnd();
    if(abs((position+5)-93)<8 && (ob5 < -200))
     score+= 1;
     else if(ob5<-200)
    {
        life--;
        if(life <= 0)
        {
            flag2 = true;
            flag = 0;
        }
    }

///Main object
glBegin(GL_POLYGON);
      glColor3ub(255,0,0);
      glVertex2i(position+0,0);
      glVertex2i(position+10,0);
      glVertex2i(position+10,4);
      glVertex2i(position+0,4);
    glEnd();

   glFlush();
}

void gameOver(){
    glColor3ub(255,0, 0);
    renderBitmapString(32,55,(void *)font1,"Game Over");
    char ar2[50];
    sprintf (ar2, "SCORE : %d", score*10);
    glColor3ub(255, 255, 0);
    renderBitmapString(32,45,(void *)font1,ar2);
}
void display()
{
    glClear(GL_COLOR_BUFFER_BIT);

    if(flag==1){
        startGame();
    }
    else if(flag2 == true){
        gameOver();
    }
    else{
        homeGame();
    }
    glFlush();
    glutSwapBuffers();
}


int main(int argc, char** argv) {
   glutInit(&argc, argv);
   glutInitWindowSize(320, 320);
   glutInitWindowPosition(50,50);
   glutCreateWindow("Catch Game");
   gluOrtho2D(0,100,0,100);
   glutDisplayFunc(display);
   init();
   PlaySound("st.wav", NULL,SND_ASYNC|SND_FILENAME|SND_LOOP);
   glutSpecialFunc(SpecialInput);
   glutKeyboardFunc(handleKeypress);
   glutTimerFunc(1000, object, 0);
   glutMainLoop();
   return 0;
}
