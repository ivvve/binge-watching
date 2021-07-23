#/bin/bash

# Copy pre-commit.sh hook
cp -f ./project-config/git-hooks/pre-commit.sh .git/hooks/pre-commit

chmod +x .git/hooks/*
