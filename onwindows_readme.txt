First, make sure the repository is is set to use LF for text files. 
Repeat these with --global to make the changes the default.
An AutoCRLF setting of input means that when committing new files,
 CRLF will be changed to LF. To just leave things alone and commit as-is, use false.

git config core.eol lf
git config core.autocrlf input

git config --global core.eol lf
git config --global core.autocrlf input

make sure all local files are recreated with the correct line-endings:

git checkout-index --force --all

If there are still some files not reporting correct line-endings, remove everything from your local copy and update them:

git rm --cached -r .
git reset --hard